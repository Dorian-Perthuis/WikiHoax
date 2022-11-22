import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'rank-table',
  templateUrl: './rank-table.component.html',
  styleUrls: ['./rank-table.component.css']
})
export class RankTableComponent implements OnInit {

  @Input() columnName : string[] = [];
  @Input() itemTable: Object[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
