package com.example.themovieapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Serializable Parcelable 인터페이스를 상속해, 안드로이드의 서로 다른 요소에서 통신
// 안드로이드는 Parcel과 바인더 시스템을 이용하는 Parcelable이 Serializable보다 더 좋은 성능을 냄
// 플러그인 설치
/**
 * 각각의 영화 아이템을 위한 데이터 클래스 정의
 * @property vote_count 투표수
 * @property vote_average 투표 평균 점수
 * @property title 영화명
 * @property release_date 출시일
 * @property poster_path 포스터의 위치
 * @property overview 영화 설명
 */
@Parcelize
data class MovieItem(
    val vote_count: Int,
    val vote_average: Float,
    val title: String,
    val release_date: String,
    val poster_path: String,
    val overview: String?
) : Parcelable

@Parcelize
data class MovieList(
    var page: Int?,
    val results: List<MovieItem>
) : Parcelable