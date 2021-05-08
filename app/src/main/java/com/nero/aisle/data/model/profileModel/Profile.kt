package com.nero.aisle.data.model.profileModel


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("approved_time")
    val approvedTime: Double?,
    @SerializedName("general_information")
    val generalInformation: GeneralInformation?,
    @SerializedName("has_active_subscription")
    val hasActiveSubscription: Boolean?,
    @SerializedName("icebreakers")
    val icebreakers: Any?,
    @SerializedName("instagram_images")
    val instagramImages: Any?,
    @SerializedName("is_facebook_data_fetched")
    val isFacebookDataFetched: Boolean?,
    @SerializedName("last_seen")
    val lastSeen: String?,
    @SerializedName("last_seen_window")
    val lastSeenWindow: String?,
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("latest_poll")
    val latestPoll: Any?,
    @SerializedName("lng")
    val lng: String?,
    @SerializedName("meetup")
    val meetup: Any?,
    @SerializedName("online_code")
    val onlineCode: Int?,
    @SerializedName("photos")
    val photos: List<Photo>?,
    @SerializedName("poll_info")
    val pollInfo: Any?,
    @SerializedName("preferences")
    val preferences: List<Preference>?,
    @SerializedName("profile_data_list")
    val profileDataList: List<ProfileData>?,
    @SerializedName("show_concierge_badge")
    val showConciergeBadge: Boolean?,
    @SerializedName("story")
    val story: Any?,
    @SerializedName("user_interests")
    val userInterests: List<Any>?,
    @SerializedName("verification_status")
    val verificationStatus: String?,
    @SerializedName("work")
    val work: Work?
)