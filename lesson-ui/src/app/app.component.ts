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

    constructor()
    {}

    ngOnInit(){}

}