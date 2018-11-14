import { Component, OnInit, OnDestroy } from '@angular/core';
import { DepartementService } from '../../../services/departement.service';
import { ClassroomService } from '../../../services/classroom.service';
import { Departement } from 'src/app/models/departement.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { isUndefined } from 'util';
import { Materiel } from 'src/app/models/material.model';
import { ActivatedRoute } from '@angular/router';
import { Classroom } from 'src/app/models/classroom.model';
import { Location } from '@angular/common';
import { MaterielService } from 'src/app/services/materiel.service';
import { Subscription } from 'rxjs';

declare const $: any;
@Component({
  selector: "app-edit-material",
  templateUrl: "./edit-material.component.html",
  styleUrls: ["./edit-material.component.css"]
})
export class EditMaterialComponent implements OnInit, OnDestroy {
  private departementsSubsc: Subscription;
  private matSubSubsc: Subscription;
  private classSubSubsc: Subscription;
  private isSelectDepVisited: boolean = false;
  private idSelectedDep: number;
  public classes: Array<Classroom> = [];
  public errorMessage = "";
  public classesPerDep = [];

  public departements: Array<Departement> = [];
  public material: Materiel;

  public formEditMat: FormGroup;

  constructor(
    private depService: DepartementService,
    private classService: ClassroomService,
    private matService: MaterielService,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit() {
    this.initForm();
    this.getIdFromUrl();
    this.subscribeToMatSubject();
    this.subscribeToDepSubject();
    this.subscribeToClassSubject();
    this.classService.getClassesOfDep(1);
  }

  ngOnDestroy() {
    this.departementsSubsc.unsubscribe();
    this.matSubSubsc.unsubscribe();
    this.classSubSubsc.unsubscribe();
  }

  getIdFromUrl() {
    this.activatedRoute.params.subscribe(params => {
      this.matService.getMaterielById(+params["id"]);
    });
  }

  subscribeToDepSubject() {
    this.departementsSubsc = this.depService.departementsSub.subscribe(
      (emittedData: Array<Departement>) => {
        this.departements = emittedData;
        this.fillArrayClassesPerDep();
        $("#spinnerDept").hide();
        $("#departement").attr("disabled", false);
        this.formEditMat.controls["departement"].setValue(
          this.material.classe.departement.id,
          { onlySelf: true }
        );
      }
    );
  }

  subscribeToMatSubject() {
    this.matSubSubsc = this.matService.singleMatSub.subscribe(
      (emittedData: Materiel) => {
        this.material = emittedData;
        this.initForm(emittedData);
        this.idSelectedDep = this.material.classe.departement.id;
        this.classes.push(this.material.classe);
        this.formEditMat.controls["classe"].setValue(this.material.classe.id, {
          onlySelf: true
        });
      }
    );
  }

  subscribeToClassSubject() {
    this.classSubSubsc = this.classService.classesPerDepSub.subscribe(
      (emittedData: Array<Classroom>) => {
        this.classes = emittedData;
        for (let i = 0; i < this.classesPerDep.length; i++) {
          if (this.classesPerDep[i].DEP_ID == this.idSelectedDep) {
            this.classesPerDep[i].CLASSROOMS = this.classes;
            $("#spinnerSalle").hide();
            $("#classe").attr("disabled", false);
            break;
          }
        }
      }
    );
  }

  initForm(material?: Materiel) {
    if (isUndefined(material)) {
      this.formEditMat = this.formBuilder.group({
        numSerie: ["", Validators.required],
        nom: ["", Validators.required],
        marque: ["", Validators.required],
        adresseIp: ["", Validators.required],
        categorie: ["", Validators.required],
        departement: ["", Validators.required],
        classe: ["", Validators.required]
      });
    } else {
      this.formEditMat = this.formBuilder.group({
        numSerie: [material.numSerie, Validators.required],
        nom: [material.nom, Validators.required],
        marque: [material.marque, Validators.required],
        adresseIp: [material.adresseIp, Validators.required],
        categorie: [material.categorie.toString(), Validators.required],
        departement: [, Validators.required],
        classe: [, Validators.required]
      });
      this.departements.push(material.classe.departement);
      this.formEditMat.controls["departement"].setValue(
        material.classe.departement.id,
        { onlySelf: true }
      );
      this.formEditMat.controls["classe"].setValue(material.classe.nom, {
        onlySelf: true
      });
    }
  }

  onChangeDep(event) {
    this.idSelectedDep = event.target.value;
    for (let i = 0; i < this.classesPerDep.length; i++) {
      if (this.classesPerDep[i].DEP_ID == this.idSelectedDep) {
        if (!this.classesPerDep[i].isFilled) {
          this.classService.getClassesOfDep(+this.idSelectedDep);
          $("#spinnerSalle").show();
          $("#classe").attr("disabled", true);
          this.classesPerDep[i].isFilled = true;
          break;
        } else {
          this.classes = this.classesPerDep[i].CLASSROOMS;
        }
      }
    }
  }

  /*onChangeClass(event) {}
  fn2() { }*/
  fn1() {
    //const params = new HttpParams().set("y","1").set("c","cc");
    if (!this.isSelectDepVisited) {
      $("#spinnerDept").show();
      $("#departement").attr("disabled", true);
      this.isSelectDepVisited = true;
      this.depService.getDepartements();
    }
  }

  fillArrayClassesPerDep() {
    let id_dep = null;
    for (let i = 0; i < this.departements.length; i++) {
      id_dep = this.departements[i].id;
      var obj = { DEP_ID: id_dep, CLASSROOMS: [], isFilled: false };
      this.classesPerDep.push(obj);
    }
  }

  onSubmitForm() {
    const formContent = this.formEditMat.value;
    console.log(formContent);
    console.log("materiel id = " + this.material.id);
    this.matService.updateMaterial(+this.material.id, formContent).then(
      (data: boolean) => {
        if(data) {
           this.location.back();
        } else{
          this.errorMessage = "une erreur est suvenue , ressayer";
        }
      }
    );
  }
}
