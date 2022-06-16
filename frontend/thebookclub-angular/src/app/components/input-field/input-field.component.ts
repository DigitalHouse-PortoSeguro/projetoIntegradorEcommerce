import { Component, forwardRef, Input, OnInit, Optional, Self } from '@angular/core';
import { ControlValueAccessor, FormControl, NgControl, NgModel, NG_VALUE_ACCESSOR, ValidationErrors } from '@angular/forms';

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
  styleUrls: ['./input-field.component.css']
})
export class InputFieldComponent implements ControlValueAccessor {
  
  @Input() id: string;
  @Input() name: string;
  @Input() title: string;
  @Input() type: FieldType = "text";
  @Input() placeholder: string = "";
  @Input() helpText: string = "";
  @Input() disabled: boolean = false;

  @Input() rows: number = 3;
  @Input() cols: number = 3;

  @Input() multiple: boolean = false;
  @Input() defaultOption: string = "Select a value";
  @Input() options: FieldOption[] = [];

  @Input() errorMessages: { [key: string]: string } = {};

  _value: any;

  constructor(
    @Optional()
    @Self()
    public ngControl: NgControl
  ) { 
    if (ngControl != null) {
      ngControl.valueAccessor = this;
    }
  }

  get value() {
    return this._value;
  }

  set value(val: any) {
    this._value = val;
    if (this.onChange) this.onChange(val);
  }

  onBlur(ev: any) {
    if (this.onTouch) this.onTouch(ev);
  }

  onChange: (_: any) => {};
  onTouch: (_: any) => {};

  writeValue(val: any): void {
    if (val != undefined) {
      this.value = val;
    }
  }

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouch = fn;
  }

  hasError() {
    return this.ngControl.invalid && (this.ngControl.dirty || this.ngControl.touched);
  }

  getErrors() {    
    return Object.keys(this.ngControl.errors as any).map(val => {
      return this.errorMessages[val] || ""
    });
  }
}
