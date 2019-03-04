import { Component, OnInit } from '@angular/core';
import { Sentence } from "./sentence.model";
import { Lesson }   from "./lesson.model";
import { LessonService } from "./service/lesson.service";
import { Router, ActivatedRoute }   from "@angular/router";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    title : string = 'lesson-ui';
    lesson : Lesson;
    lessonId: number;
    contentLines: string[];
    sentences : Sentence[];
    url    : string;
    startLesson: boolean;

    constructor(private lessonService : LessonService, 
        private route : ActivatedRoute){}

    ngOnInit(){
        console.log(this.route.data);
        this.route.data.forEach((data)=>{
            this.lessonId = data["id"];
        });
    	this.url    = this.route.snapshot.params["id"];
    	this.title  = this.url;

        console.log(this.route.snapshot);
        
    	this.lessonService.getLesson(13)
        .subscribe((lesson : Lesson) => {
    		this.lesson = lesson;
    		this.sentences = lesson.sentences;
    		// To display the grammar content as a full paragraph
    		this.contentLines = this.lesson.content.split("\r\n");

    	});
    }

    setStartLesson(value: boolean){
        console.log("Value changed to " + value);
    	this.startLesson = value;
    }


}