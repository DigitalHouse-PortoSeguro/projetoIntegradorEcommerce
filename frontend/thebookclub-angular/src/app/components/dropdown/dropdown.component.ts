import { Component, EventEmitter, Input, OnInit, Optional, Output, Self } from '@angular/core';
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
  @Input() defaultOption: string = "Select a value";
  @Input() options: string[] = [];
  @Input() texts: string[] = [];
  @Output() blur: EventEmitter<any> = new EventEmitter();
  
  disabled: boolean = false;
  //_value: any;

  _value: any = "";

  constructor(
    @Optional()
    @Self()
    public ngControl: NgControl
  ) { 
    if (ngControl != null) {
      ngControl.valueAccessor = this;
    }
  }

  getText(i: number): string {
    if (i >= this.texts.length) {
      let s = this.options[i];
      s = s.charAt(0).toUpperCase() + s.slice(1).toLowerCase()
      return s;
    }
    return this.texts[i];
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
    if (!this.ngControl) return false;
    return this.ngControl.invalid && (this.ngControl.dirty || this.ngControl.touched);
  }

  getErrors(): string[] {
    if (!this.ngControl?.errors) return [];
    return Object.values(this.ngControl.errors as any);
  }
}
