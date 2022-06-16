import { Component, forwardRef, Input, OnInit } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';

const INPUT_CUSTOM_VALUE_ACESSOR: any = {
  provide: NG_VALUE_ACCESSOR,
  useExisting: forwardRef(() => InputCustomComponent),
  multi: true
}

@Component({
  selector: 'app-input-custom',
  templateUrl: './input-custom.component.html',
  styleUrls: ['./input-custom.component.css']
})
export class InputCustomComponent implements ControlValueAccessor {

  @Input() modelo:any;
  @Input() label: string;
  @Input() type:string;
  @Input() placeholder:string;
  @Input() readOnly: boolean = false;

  //valor para utilizar dentro do escopo da classe
  private valorInput: any;

  get value() {
    return this.valorInput;
  }
  //controla como o valor é setado 
  set value(valor:any) {
    //se o valor não mudar, não é necessário disparar o evento para mudar o valor
    if(valor!== this.valorInput) {
      this.valorInput = valor;
      this.onChangeCallback(valor);
    }
  }

  constructor() { }

  //funções para que o angular implemente a lógica correta quando necessário:
  onChangeCallback: (_: any) => void = () => {};
  onTouchedCallback: (_: any) => void = () => {};

  //método para acompanhar qual o valor do campo input:
  writeValue(valor: any): void {
   //chamar a função set value:
    this.value = valor;
  }
  //como lidar com a mudança no input:
  registerOnChange(fn: any): void {
    this.onChangeCallback = fn;
  }
  //como lidar com o input quando ele ganhar foco: 
  registerOnTouched(fn: any): void {
    this.onTouchedCallback = fn;
  }
  setDisabledState?(isDisabled:boolean): void {
    this.readOnly = isDisabled;
  }

  

}
