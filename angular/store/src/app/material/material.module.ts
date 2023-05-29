import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardActions, MatCardModule } from '@angular/material/card';
import {MatBadgeModule} from '@angular/material/badge';
import { MatTableModule } from '@angular/material/table';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { LayoutModule } from '@angular/cdk/layout';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatStepperModule} from '@angular/material/stepper';
@NgModule({
  declarations: [],
  imports: [
    CommonModule, MatButtonModule, MatToolbarModule, MatIconModule, MatCardModule,
    MatInputModule, MatGridListModule, MatMenuModule, MatPaginatorModule, MatSortModule, MatSidenavModule,
    MatSelectModule, MatTableModule, MatListModule, LayoutModule, MatFormFieldModule,
    MatRadioModule,MatBadgeModule,MatStepperModule
  ], exports: [
    MatButtonModule, MatToolbarModule, MatIconModule, MatCardModule,
    MatInputModule, MatGridListModule, MatMenuModule, MatPaginatorModule, MatSortModule, MatSidenavModule,
    MatSelectModule, MatTableModule, MatListModule, LayoutModule, MatFormFieldModule,
    MatRadioModule,MatCardActions,MatBadgeModule,MatStepperModule
  ]
})
export class MaterialModule { }
