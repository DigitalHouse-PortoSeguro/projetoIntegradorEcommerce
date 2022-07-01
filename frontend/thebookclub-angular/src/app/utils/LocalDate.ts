import { formatDate } from "@angular/common";


export class LocalDate extends Date {

	public override toString(): string {
		return formatDate(super.toString(), "yyyy-MM-dd", "en-US");
	}

	public override toJSON(key?: any): string {
		return this.toString();
	}

	public static fromString(s: string): LocalDate {
		const utc = new Date(s);

		return new LocalDate(utc.getTime() + utc.getTimezoneOffset() * 60000);
	}
}

export class LocalDateTime extends Date {
	public override toString(): string {
		return formatDate(super.toString(), "yyyy-MM-dd HH:mm:ss", "en-US");
	}

	public override toJSON(key?: any): string {
		return this.toString();
	}

	public static fromString(s: string): LocalDateTime {
		const utc = new Date(s);

		return new LocalDateTime(utc.getTime() + utc.getTimezoneOffset() * 60000);
	}
}