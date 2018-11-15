import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReclamationService {

  constructor(private _http: HttpClient) { }

  public addReclamation(info1,info2): Observable<any>{
    let object = {
      objectif: info1.objectif,
      description: info1.description,
      date_creation: new Date(),
      chef_dep_id: 1,
      mat_id: info2.id
    }

    return this._http.post("http://localhost:8080/api/chefDep/add_reclamation",object);
  }
}
