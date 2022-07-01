import { Component, EventEmitter, forwardRef, Input, OnInit, Optional, Output, Self } from '@angular/core';
import { ControlValueAccessor, FormControl, NgControl, NgModel, NG_VALUE_ACCESSOR, ValidationErrors } from '@angular/forms';

// Tipo do input
type FieldType =
  "button" | "checkbox" | "color" | "date" |
  "datetime-local" | "email" | "file" | "hidden" |
  "image" | "month" | "number" | "password" | "radio" |
  "range" | "reset" | "search" | "submit" | "tel" |
  "text" | "time" | "url" | "week";

// Uma função que retorna os erros de um form control
type GetControlErrorsFunction = (control: NgControl) => string[];
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
  @Output() blur: EventEmitter<any> = new EventEmitter();
  
  disabled: boolean = false;
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
    this.blur.emit(ev);
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

  setDisabledState(isDisabled: boolean): void {
    this.disabled = isDisabled;
  }

  hasError() {
    return this.ngControl.invalid && (this.ngControl.touched || (this.ngControl.touched && this.ngControl.dirty));
  }

  getErrors(): string[] {
    if (!this.ngControl?.errors) return [];
    return Object.values(this.ngControl.errors as any);
  }
}
