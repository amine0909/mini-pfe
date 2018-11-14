import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MaterielService {

  constructor(private _http: HttpClient) { }

  public getAllMaterielByChefDep(chefDepId): Observable<any> {
    let GraphQlQuery  = '{AllMaterielsByChefDepart(chefDepartId: "1") {nom marque numSerie categorie adresseIp  dateAchat classe {  id nom }} }'
    return this._http.post("http://localhost:8080/materiels",GraphQlQuery);
  }
}
