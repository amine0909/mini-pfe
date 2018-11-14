import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ModalListMaterielParCheDepComponent } from '../modal-list-materiel-par-che-dep/modal-list-materiel-par-che-dep.component';

@Component({
  selector: 'app-add-reclamation',
  templateUrl: './add-reclamation.component.html',
  styleUrls: ['./add-reclamation.component.css']
})
export class AddReclamationComponent implements OnInit {

  constructor(public ModalListMaterielParCheDepComponent: MatDialog ) { }

  ngOnInit() {
  }


  public openModalListMateriel() {
    const dialogRef = this.ModalListMaterielParCheDepComponent.open(ModalListMaterielParCheDepComponent, {
      width: "500px",
      hasBackdrop: true,
      disableClose: true
      
    })

    dialogRef.afterClosed().subscribe((result) => {
      console.log("modal closer")
    })
  }

}
