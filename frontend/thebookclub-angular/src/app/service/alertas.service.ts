import { Injectable } from '@angular/core';
//import { BsModalRef, BsModalService} from 'ngx-bootstrap/modal';
import { Observable, Subject } from 'rxjs';
import { AlertasComponent } from '../alertas/alertas.component';

@Injectable({
  providedIn: 'root'
})
export class AlertasService {

  private onAlert: Subject<any> = new Subject();

  constructor(
    //private bsModalService: BsModalService
  ) { }

  private showAlert(message: string, type: string, duration: number = 5000){
    /*const bsModalRef: BsModalRef = this.bsModalService.show(AlertasComponent)
    bsModalRef.content.type = type
    bsModalRef.content.message = message*/

    this.onAlert.next({type, message, duration});
  }

  showAlertDanger(message: string, duration: number = 5000){
    this.showAlert(message, 'danger', duration);
  }

  showAlertSucess(message: string, duration: number = 5000){
    this.showAlert(message, 'success', duration);
  }

  showAlertInfo(message: string, duration: number = 5000){
    this.showAlert(message, 'info', duration);
  }

  getOnAlert(): Observable<any> {
    return this.onAlert.asObservable();
  }
}
