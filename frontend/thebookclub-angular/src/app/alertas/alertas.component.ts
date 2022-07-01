import { Component, Input, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { AlertasService } from '../service/alertas.service';

@Component({
  selector: 'app-alertas',
  templateUrl: './alertas.component.html',
  styleUrls: ['./alertas.component.css']
})
export class AlertasComponent implements OnInit {

  message: string = '';
  type: string = 'success';
  isOpen: boolean = false;

  constructor(
    private alertaService: AlertasService
  ) { 
    this.alertaService.getOnAlert().subscribe(alert => {
      this.message = alert.message;
      this.type = alert.type;
      this.isOpen = true;
      console.log(this.message);
      console.log(this.type);
      console.log(this.isOpen);
    })
  }

  ngOnInit() {
    
  }

  onClose(){
    this.isOpen = false;
  }

}
