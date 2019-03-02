import { Sentence } from "./sentence.model";

export interface Lesson{
	id: number;
	title: string;
	content: string;
	sentences: Sentence[];
	words: string[];
	grammar : string[];
	language: any;
	level   : any;
}
