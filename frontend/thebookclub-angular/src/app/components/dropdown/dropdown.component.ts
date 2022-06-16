import { Component, Input, OnInit, Optional, Self } from '@angular/core';
import { ControlValueAccessor, NgControl } from '@angular/forms';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent implements ControlValueAccessor {

  @Input() id: string;
  @Input() name: string;
  @Input() title: string;
  @Input() helpText: string = "";
  @Input() disabled: boolean = false;
  @Input() defaultOption: string = "Select a value";
  @Input() options: string[] = [];

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
    return Object.keys(this.ngControl.errors as any);
  }
}
