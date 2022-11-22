import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http: HttpClient) { }

  getGamePage(): Observable<gamePage> {
    return this.http.get<gamePage>("localhost:4200/get-todays-page")
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    console.error('server error:', error);
    if (error.error instanceof Error) {
      const errMessage = error.error.message;
      return throwError(() => errMessage);
    }
    return throwError(() => error || 'Server error');
  }
}

export interface gamePage{
  id: number,
  title : string,
  description : string,
  images : image[],
}

export interface image{
  id:number,
  url: number
}