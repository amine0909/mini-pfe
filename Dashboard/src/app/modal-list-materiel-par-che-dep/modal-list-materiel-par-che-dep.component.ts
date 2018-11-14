import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-modal-list-materiel-par-che-dep',
  templateUrl: './modal-list-materiel-par-che-dep.component.html',
  styleUrls: ['./modal-list-materiel-par-che-dep.component.css']
})
export class ModalListMaterielParCheDepComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ModalListMaterielParCheDepComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string) { }

  ngOnInit() {
  }

}
