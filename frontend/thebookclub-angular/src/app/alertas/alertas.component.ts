import { Component, Input, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { AlertasService } from '../service/alertas.service';

@Component({
  selector: 'app-alertas',
  templateUrl: './alertas.component.html',
  styleUrls: ['./alertas.component.css']
})
export class AlertasComponent implements OnInit {

  title: string = '';
  message: string = '';
  type: string = 'success';
  isOpen: boolean = false;
  timer: any = null;

  constructor(
    private alertaService: AlertasService
  ) { 
    this.alertaService.getOnAlert().subscribe(alert => {
      this.title = alert.title;
      this.message = alert.message;
      this.type = alert.type;
      this.isOpen = true;
      if (this.timer) clearTimeout(this.timer);
      this.timer = setTimeout(() => this.onClose(), alert.duration);
    })
  }

  ngOnInit() {
    
  }

  onClose(){
    this.isOpen = false;
  }

}
