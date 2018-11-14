import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { EditMaterialComponent } from './materials/edit-material/edit-material.component';
import { DeleteMaterialComponent } from './materials/delete-material/delete-material.component';
import { SharedModule } from '../shared/shared-module.module';



@NgModule({
  imports: [
    CommonModule,
    AdminRoutingModule,
    SharedModule
  ],
  declarations: [EditMaterialComponent, DeleteMaterialComponent]
})
export class AdminModule {
  constructor() {
    console.log("***Lazy Loaded AdminModule***");
  }
 }