import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Inmueble } from 'src/app/core/model/Inmueble';
import { Peticion } from 'src/app/core/model/Peticion';
import { Usuario } from 'src/app/core/model/Usuario';
import { InmuebleService } from 'src/app/core/services/inmueble/inmueble.service';
import { PeticionService } from 'src/app/core/services/peticion/peticion.service';

@Component({
  selector: 'app-furniture-detaile',
  templateUrl: './furniture-detaile.component.html',
  styleUrls: ['./furniture-detaile.component.scss']
})
export class FurnitureDetaileComponent implements OnInit {

  inmueble?: Inmueble;
  cliente !: Usuario;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private inmuebleService: InmuebleService,
    private peticionService: PeticionService) {
    this.cliente = {//EL USUARIO SIEMPRE SERA EL PRIMERO PARA LAS PRUEBAS
      idusuario: 1,
      correo: undefined,
      password: undefined,
      nombre: undefined,
      rol: undefined,
      telefono: undefined,
    }
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      const idinmueble: string = params["idinmueble"];
      this.featch(idinmueble);
    });
  }

  featch(idinmueble: string) {
    this.inmuebleService.getbyIdInmueble(idinmueble).subscribe((item: Inmueble) => {
      this.inmueble = item;

    });
  }

  reserve(event: Event) {
    event.preventDefault();
    const peticion: Peticion = {//crear peticion
      idpeticion: undefined,
      estado: 'P',
      cliente: this.cliente,
      inmueble: this.inmueble
    }
    this.peticionService.createPeticion(peticion)
      .subscribe(res =>{
        this.router.navigate(['/menu/furniture']);
      })
    console.log(peticion);
  }

}
