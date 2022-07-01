import { Injectable } from '@angular/core';
//import { BsModalRef, BsModalService} from 'ngx-bootstrap/modal';
import { Observable, Subject } from 'rxjs';
import { AlertasComponent } from '../alertas/alertas.component';

type AlertInfo = {
  type: string,
  title: string,
  message: string,
  duration: number
};

@Injectable({
  providedIn: 'root'
})
export class AlertasService {

  private onAlert: Subject<AlertInfo> = new Subject();

  constructor(
    //private bsModalService: BsModalService
  ) { }

  private showAlert(title: string, message: string, type: string, duration: number = 5000){
    /*const bsModalRef: BsModalRef = this.bsModalService.show(AlertasComponent)
    bsModalRef.content.type = type
    bsModalRef.content.message = message*/

    this.onAlert.next({type, title, message, duration});
  }

  showAlertDanger(title: string, message: string = "", duration: number = 5000){
    this.showAlert(title, message, 'danger', duration);
  }

  showAlertSucess(title: string, message: string = "", duration: number = 5000){
    this.showAlert(title, message, 'success', duration);
  }

  showAlertInfo(title: string, message: string = "", duration: number = 5000){
    this.showAlert(title, message, 'info', duration);
  }

  getOnAlert(): Observable<any> {
    return this.onAlert.asObservable();
  }
}
