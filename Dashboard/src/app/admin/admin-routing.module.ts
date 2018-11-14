import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditMaterialComponent } from './materials/edit-material/edit-material.component';

const routes: Routes = [
  {
    path:':id/edit',
    component:EditMaterialComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
