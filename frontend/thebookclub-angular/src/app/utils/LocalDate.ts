import { formatDate } from "@angular/common";


export class LocalDate extends Date {
	public override toJSON(key?: any): string {
		return formatDate(this, "yyyy-MM-dd", "en-US");
	}
}

export class LocalDateTime extends Date {
	public override toString(): string {
		return formatDate(this, "yyyy-MM-dd HH:mm:ss", "en-US");
	}

	public override toJSON(key?: any): string {
		return this.toString();
	}
}