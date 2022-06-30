import { AbstractControl, Validators } from "@angular/forms";


export default class CustomValidators {
	public static required(message: string) {
		return function (control: AbstractControl) {
			const err = Validators.required(control);

			if (err) {
				err['required'] = message;
			}

			return err;
		}
	}

	public static pattern(pattern: string | RegExp, message: string) {
		const func = Validators.pattern(pattern);
		return function (control: AbstractControl) {
			const err = func(control);

			if (err) {
				err['pattern'] = message;
			}

			return err;
		}
	}

	public static minLength(val: number, message: string) {
		const func = Validators.minLength(val);
		return function (control: AbstractControl) {
			const err = func(control);

			if (err) {
				err['minlength'] = message;
			}

			return err;
		}
	}

	public static size(min: number, max: number, message: string) {
		return function (control: AbstractControl) {
			const len = control.value.length;

			if (len < min || len > max) {
				return {
					'size': message
				}
			}

			return null;
		}
	}

	public static email(message: string) {
		return function (control: AbstractControl) {
			const err = Validators.email(control);

			if (err) {
				err['email'] = message;
			}

			return err;
		}
	}

	public static matchField(controlName: string, message: string) {
		return function (control: AbstractControl) {
			const otherControl = control.root?.get(controlName);

			if (otherControl && control.value !== '') {
				if (otherControl.value !== control.value) {
					return {'matchField': message}
				}
			}

			return null;
		}
	}
}
