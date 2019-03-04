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

    constructor() {}
    ngOnInit() {}

    back(){
        console.log("back to main component from lesson");
    	this.setStartLesson.emit(false);
    }
}