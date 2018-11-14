import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Subject } from "rxjs";
import { Classroom } from "src/app/models/classroom.model";
import { API_BASE_URL } from "../commons/common";
@Injectable()
export class ClassroomService {
   public classesPerDepSub: Subject<Classroom[]> = new Subject<Classroom[]>(); 

   private classes: Array<Classroom> = [];
   constructor(private httpClient: HttpClient) {}

   getClassesOfDep(id: number) {
       this.httpClient.get<Array<Classroom>>(API_BASE_URL + "/admin/classes/" + id).subscribe(
          (data: Array<Classroom>) => {
             this.classes = data;
             this.emitClassesPerDepSub();
          }, (errorRep: HttpErrorResponse) => {}
       );
   }
   
   private emitClassesPerDepSub() {
       this.classesPerDepSub.next(this.classes.slice());
   }
  
}