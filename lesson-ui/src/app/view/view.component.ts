import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute }   from "@angular/router";
import { Sentence } from "../sentence.model";
import { Lesson }   from "../lesson.model";
import { LessonService } from "../service/lesson.service";


@Component({
    selector: 'view-component',
    templateUrl: './view.component.html',
    styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

    lesson : Lesson;
    lessonId: number;
    contentLines: string[];
    sentences : Sentence[];
    url    : string;
    startLesson: boolean;

    constructor(private lessonService : LessonService, 
        private route : ActivatedRoute, private router : Router)
    {}

    ngOnInit(){

        this.route.params.subscribe((param : any)=>{
            this.lessonId = param["id"];

            this.lessonService.getLesson(this.lessonId)
            .subscribe((lesson : Lesson)=>{

                if(lesson == null){
                    this.router.navigate(["/not-found"]);
                }
                
                this.lesson = lesson;
        		this.sentences = this.lesson.sentences;
                // To display the grammar content as a full paragraph
                this.contentLines = this.lesson.content.split("\r\n");
            });
        });

    }

    setStartLesson(value: boolean){
    	this.startLesson = value;
    }
}