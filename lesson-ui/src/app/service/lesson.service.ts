import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Lesson } from "../lesson.model";
import { Sentence } from "../sentence.model";


@Injectable({
    providedIn: 'root'
})
export class LessonService {

    constructor(private httpClient : HttpClient) {}

    getLesson(id : number) : any{

    }

    getLessons(): any{

    }
}