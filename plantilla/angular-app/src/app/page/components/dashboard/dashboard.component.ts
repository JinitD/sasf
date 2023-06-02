import { Component } from '@angular/core';
import { AreaConocimineto, Citas } from 'src/app/core/model/Model';
import { CitaService } from 'src/app/core/service/cita/cita.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  citas !: Citas[];
  areaConocmiento !: AreaConocimineto[];
  constructor(
    private citaService: CitaService
  ) {
    this.fetch();
  }

  fetch() {
    // this.citaService.getAllArea().subscribe(item => {
    //   this.areaConocmiento = item;
    //   console.log(this.citas)
    // });

    this.citaService.getAllCitas().subscribe(item => {
      this.citas = item;
      console.log(this.citas)
    });
  }
}
