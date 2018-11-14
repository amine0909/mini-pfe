import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http'
import { Observable, Subject } from 'rxjs';
import { Materiel } from '../models/material.model';
import { API_BASE_URL } from '../commons/common';
@Injectable({
  providedIn: 'root'
})
export class MaterielService {
  public singleMatSub: Subject<Materiel> = new Subject<Materiel>();
  private httpClient;
  constructor(private _http: HttpClient) { 
    this.httpClient = _http;
  }

  public getAllMaterielByChefDep(chefDepId): Observable<any> {
    let GraphQlQuery  = '{AllMaterielsByChefDepart(chefDepartId: "1") {id nom marque numSerie categorie adresseIp  dateAchat classe {  id nom }} }'
    return this._http.post("http://localhost:8080/materiels",GraphQlQuery);
  }
  getMaterielById(id: number) {
    this.httpClient.get(API_BASE_URL + "/materiel/" + id + "/get").subscribe(
      (data: Materiel) => {
        this.emitSingleMatSub(data);
      }, (errorRep: HttpErrorResponse) => {
        if (errorRep.status === 404) {
          //record not found
        }
      }
    );
  }

  updateMaterial(id: number, material: any): Promise<Boolean> {
    return new Promise<Boolean>((resolve, reject) => {
      this.httpClient.post(API_BASE_URL + "/materiels/" + id + "/update", material).subscribe(
        (successData) => {
          resolve(true);
        }, (errorRep: HttpErrorResponse) => {
          if (errorRep.status != 500 && errorRep.status != 404) resolve(true);
          else resolve(false);
        }
      );
    });
  }


  private handleError(erroResponse: HttpErrorResponse) {
    if (erroResponse.error instanceof ErrorEvent) {
      //client side error ( internet connection )
    } else {
      //server side error
    }
  }

  private emitSingleMatSub(materiel: Materiel) {
    this.singleMatSub.next(materiel);
  }
}
