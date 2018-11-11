import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {

  public listProducts = [
    {
      name: "Lenovo IdeaPad320",
      marque: "Lenovo",
      AdresseIP: "192.168.0.1",
      dateAchat: "09/11/2018"
    },
    {
      name: "Lenovo IdeaPad320",
      marque: "Lenovo",
      AdresseIP: "192.168.0.1",
      dateAchat: "09/11/2018"
    },
    {
      name: "Lenovo IdeaPad320",
      marque: "Lenovo",
      AdresseIP: "192.168.0.1",
      dateAchat: "09/11/2018"
    },
    {
      name: "Lenovo IdeaPad320",
      marque: "Lenovo",
      AdresseIP: "192.168.0.1",
      dateAchat: "09/11/2018"
    },
    {
      name: "Lenovo IdeaPad320",
      marque: "Lenovo",
      AdresseIP: "192.168.0.1",
      dateAchat: "09/11/2018"
    }
  ]
  constructor(private _router: Router) { }

  ngOnInit() {
  }


  public redirecTo() {
    this._router.navigate(["/products/add_product"]);
  }

}
