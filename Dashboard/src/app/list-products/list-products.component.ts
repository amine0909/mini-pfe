import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MaterielService } from '../services/materiel.service';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {

  public listProducts = []
  constructor(private _router: Router, private _materielService: MaterielService) { }

  ngOnInit() {
    this.fetchMateriels();
  }


  public fetchMateriels() {
    this._materielService.getAllMaterielByChefDep(1)
      .subscribe((result) => {
        console.log(result)
        this.listProducts = result.data.AllMaterielsByChefDepart
      })
  }

}
