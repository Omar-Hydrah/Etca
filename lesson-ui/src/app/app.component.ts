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
        private route : ActivatedRoute, private router : Router)
    {
        router.events.subscribe((event : any)=>{
            if(event.url && event.urlAfterRedirects){
                const lessonMatch = event.url.match(/\d{1,2}/g);
                if(lessonMatch == null){
                    router.navigate(["/not-found"])
                }
                this.lessonId = lessonMatch[0];
            }
        });
    }

    ngOnInit(){

    	this.lessonService.getLesson(13)
        .subscribe((lesson : Lesson) => {
    		this.lesson = lesson;
    		this.sentences = lesson.sentences;
    		// To display the grammar content as a full paragraph
    		this.contentLines = this.lesson.content.split("\r\n");

    	});
    }

    setStartLesson(value: boolean){
    	this.startLesson = value;
    }


}