import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Inmueble } from 'src/app/core/model/Inmueble';
import { InmuebleService } from 'src/app/core/services/inmueble/inmueble.service';

@Component({
  selector: 'app-furniture-detaile',
  templateUrl: './furniture-detaile.component.html',
  styleUrls: ['./furniture-detaile.component.scss']
})
export class FurnitureDetaileComponent implements OnInit {
 
  inmueble ?: Inmueble;
  constructor(
    private route: ActivatedRoute,
    private inmuebleService: InmuebleService) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      const idinmueble: string = params["idinmueble"];
      this.featch(idinmueble);
    });
  }

  featch(idinmueble: string) {
    this.inmuebleService.getbyIdInmueble(idinmueble).subscribe(item => {
      this.inmueble = item;
    });
  }

}
