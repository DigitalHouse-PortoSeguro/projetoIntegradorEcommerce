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

  private showAlert(message: string, type: string){
    /*const bsModalRef: BsModalRef = this.bsModalService.show(AlertasComponent)
    bsModalRef.content.type = type
    bsModalRef.content.message = message*/

    this.onAlert.next({type, message});
  }

  showAlertDanger(message: string){
    this.showAlert(message, 'danger')
  }

  showAlertSucess(message: string){
    this.showAlert(message, 'success')
  }

  showAlertInfo(message: string){
    this.showAlert(message, 'info')
  }

  getOnAlert(): Observable<any> {
    return this.onAlert.asObservable();
  }
}
