import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';

import { Lesson } from "../lesson.model";

@Component({
    selector: 'main-component',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
	@Input() lesson : Lesson;
	@Input() contentLines : string;
	
    @Output() setStartLesson = new EventEmitter();

    constructor() {}
    ngOnInit() {}

    launchLesson(){
    	this.setStartLesson.emit(true);
    }

}