import { Component, EventEmitter, Input, Optional, Output, Self } from '@angular/core';
import { ControlValueAccessor, NgControl } from '@angular/forms';

@Component({
  selector: 'app-textarea',
  templateUrl: './textarea.component.html',
  styleUrls: ['./textarea.component.css']
})
export class TextareaComponent implements ControlValueAccessor {

  @Input() id: string;
  @Input() name: string;
  @Input() title: string;
  @Input() placeholder: string = "";
  @Input() helpText: string = "";
  @Input() rows: number = 3;
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
