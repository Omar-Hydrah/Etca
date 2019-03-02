import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, of } from "rxjs";
import { catchError } from "rxjs/operators";
import { Lesson } from "../lesson.model";
import { Sentence } from "../sentence.model";


@Injectable({
    providedIn: 'root'
})
export class LessonService {

    constructor(private http : HttpClient) {}

    getLesson(id : number) : Observable<Lesson>{
    	return this.http.get<Lesson>("/api/lesson/" + id)
    		.pipe(catchError(this.handleError<Lesson>("getLesson")));
    }

    getLessons(): Observable<Lesson[]>{
    	return this.http.get<Lesson[]>("/api/lesson/all")
    		.pipe(catchError(this.handleError<Lesson[]>("getLesssons", [])));
    }

    private handleError<T>(operation="operation", result ? : T){
    	return (error : any) : Observable<T> =>{
    		console.error(error);
    		return of(result as T);
    	}
    }
}