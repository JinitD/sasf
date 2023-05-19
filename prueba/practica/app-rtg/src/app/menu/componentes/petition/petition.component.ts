import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Peticion } from 'src/app/core/model/Peticion';
import { Usuario } from 'src/app/core/model/Usuario';
import { PeticionService } from 'src/app/core/services/peticion/peticion.service';

@Component({
  selector: 'app-petition',
  templateUrl: './petition.component.html',
  styleUrls: ['./petition.component.scss']
})
export class PetitionComponent {
  peticion!: Peticion[];
  cliente !: Usuario;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private peticionService: PeticionService) {
    this.cliente = {
      idusuario: 1,
      correo: undefined,
      password: undefined,
      nombre: undefined,
      rol: undefined,
      telefono: undefined,
    }
    this.fetch();
  }


  fetch(){
    this.peticionService.getAllPeticion().subscribe(peticion => {
      this.peticion = peticion;
      console.log(this.peticion)
    });
  }
}
