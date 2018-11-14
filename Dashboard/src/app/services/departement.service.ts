import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Subject } from "rxjs";
import { Departement } from "../models/departement.model";
import { API_BASE_URL } from "../commons/common";



@Injectable()
export class DepartementService  {
    private departements: Array<Departement> = [];
    public departementsSub: Subject<Departement[]> = new Subject<Departement[]>();
    constructor(private httpClient: HttpClient) {
        console.log('***ClassroomService Instanciated***');
    }

    getDepartements() {
        this.httpClient.get<Array<Departement>>(API_BASE_URL + "/admin/departements").subscribe(
           (data: Array<Departement>) => {
              this.departements = data;
              this.emitDepartementsSubject();
           } , (error: HttpErrorResponse) =>{} 
        );
    }

    emitDepartementsSubject() {
        this.departementsSub.next(this.departements.slice());
    }
}