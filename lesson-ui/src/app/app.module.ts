import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule }      from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LessonService } from "./service/lesson.service";
import { MainComponent } from './main/main.component';
import { LessonComponent } from './lesson/lesson.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ViewComponent } from './view/view.component';
import { BlankComponent } from './blank/blank.component';
import { SentenceComponent } from './sentence/sentence.component';

@NgModule({
    declarations: [
        AppComponent,
        MainComponent,
        LessonComponent,
        NotFoundComponent,
        ViewComponent,
        BlankComponent,
        SentenceComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
    ],
    providers: [
        LessonService,
    ],
    bootstrap: [AppComponent]
})
export class AppModule {}