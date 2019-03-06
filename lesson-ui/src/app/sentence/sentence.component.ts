import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Sentence } from "../sentence.model";

@Component({
    selector: 'sentence-component',
    templateUrl: './sentence.component.html',
    styleUrls: ['./sentence.component.css']
})
export class SentenceComponent implements OnInit {

	@Input() sentence : Sentence;
	@Output() next = new EventEmitter();

	answer : string;
	success : boolean = true;

    constructor() {}
    ngOnInit() {
        console.log("sentence", this.sentence);
    }

    checkAnswer(){
        console.log("answer", this.answer);
        console.log("tr", this.sentence.translation);
        console.log(this.answer == this.sentence.translation);

    	if(this.answer != this.sentence.translation){
    		this.success = false;
    	}else{
            this.success = true;
            this.answer = null;
    		this.next.emit(true);
    	}
    }
}