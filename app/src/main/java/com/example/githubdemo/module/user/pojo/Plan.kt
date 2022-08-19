import com.google.gson.annotations.SerializedName

data class Plan (

	@SerializedName("name") val name : String,
	@SerializedName("space") val space : Int,
	@SerializedName("private_repos") val private_repos : Int,
	@SerializedName("collaborators") val collaborators : Int
)