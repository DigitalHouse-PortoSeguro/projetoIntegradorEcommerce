import { Component, forwardRef, Input, OnInit } from '@angular/core';
import { ControlValueAccessor, FormControl, NgModel, NG_VALUE_ACCESSOR } from '@angular/forms';

// Tipo do input
type FieldType =
  "button" | "checkbox" | "color" | "date" |
  "datetime-local" | "email" | "file" | "hidden" |
  "image" | "month" | "number" | "password" | "radio" |
  "range" | "reset" | "search" | "submit" | "tel" |
  "text" | "time" | "url" | "week"  | "textarea" | "select";

// Tipo de uma opção
type FieldOption = {
  value: any,
  displayName: string
};

// Tipo de uma função de validação
type ValidationFunction = (val: any) => string[];
@Component({
  selector: 'app-input-field',
  templateUrl: './input-field.component.html',
  styleUrls: ['./input-field.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => InputFieldComponent),
      multi: true
    }
  ]
})
export class InputFieldComponent implements ControlValueAccessor {
  
  @Input() id: string;
  @Input() name: string;
  @Input() title: string;
  @Input() type: FieldType = "text";
  @Input() placeholder: string = "";
  @Input() helpText: string = "";
  @Input() disabled: boolean = false;

  @Input() control: FormControl;

  @Input() rows: number = 3;
  @Input() cols: number = 3;

  @Input() multiple: boolean = false;
  @Input() defaultOption: string = "Select a value";
  @Input() options: FieldOption[] = [];

  _value: any;

  get value() {
    return this._value;
  }

  set value(val: any) {
    this._value = val;
    if (this.propagateChange) this.propagateChange(val);
  }

  constructor() { }

  propagateChange: (_: any) => {};

  writeValue(val: any): void {
    if (val != undefined) {
      this.value = val;
    }
  }
  registerOnChange(fn: any): void {
    this.propagateChange = fn;
  }
  registerOnTouched(fn: any): void {}

  

}
