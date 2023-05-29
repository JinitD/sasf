import { Component } from '@angular/core';
import { Inmueble } from 'src/app/core/model/Inmueble';
import { InmuebleService } from 'src/app/core/services/inmueble/inmueble.service';

@Component({
  selector: 'app-furniture',
  templateUrl: './furniture.component.html',
  styleUrls: ['./furniture.component.scss']
})
export class FurnitureComponent {

  inmuebles!: Inmueble[];
  constructor(private inmuebleService: InmuebleService) {
    this.fetch();
  }

  fetch() {
    this.inmuebleService.getAllinmuebles().subscribe(inmue => {
      this.inmuebles = inmue;
      console.log(this.inmuebles)
    });
  }
}
