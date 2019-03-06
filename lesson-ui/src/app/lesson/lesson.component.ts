import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';

import { Sentence } from "../sentence.model"; 

@Component({
    selector: 'lesson-component',
    templateUrl: './lesson.component.html',
    styleUrls: ['./lesson.component.css']
})
export class LessonComponent implements OnInit {
	@Input() sentences : Sentence[];
	@Output() setStartLesson = new EventEmitter();

    sentence     : Sentence;
    sentenceGenerator : any;

    constructor() {}
    ngOnInit() {
        this.sentenceGenerator = this.generateSentences();
        this.sentence = this.sentenceGenerator.next().value;
    }

    next(){
        this.sentence = this.sentenceGenerator.next().value;
        if(this.sentence == null){
            this.back();
        }
    }

    back(){
    	this.setStartLesson.emit(false);
    }

    *generateSentences(){
        for(var i = 0; i < this.sentences.length; i++){
            yield this.sentences[i];
        }
    }
}