import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {


public static void main(String[] args) throws FacebookException {
//Lenny Estika Sari NIM 16.01.53.0137
 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("4519097989xxxxx", "103b804b6402526e5655dfa2509xxxxx");
// Get an access token from: 
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString = "xxxxxxxxxxxxAAV0JfhlwWyjDbX3mSbAcLZAb3aJobRHQ0q9csMRiOZAR6oGotAji2ZBqxdK1ltzXnaZAXdxeHW2T0j2DmrsjwZCgQy4ZBSYDWcxA1dULkSRgbyAQutWNdP5rf5RFRY87RGG9AIYOVuNXUUJi8P3yLVJFCGLK2jxzN3kwQHWh4KNA4Nl3ZAO4oETZBZAH6av";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

 ResponseList<Post> feeds = facebook.getFeed("xxxxx30612089925",
new Reading().limit(25));

 // For all 25 feeds...
for (int i = 0; i < feeds.size(); i++) {
// Get post.
Post post = feeds.get(i);
// Get (string) message.
String message = post.getMessage();
// Print out the message.
System.out.println(message);
PagableList comments = post.getComments();
String date = post.getCreatedTime().toString();
// String name = post.getFrom().getName();
String id = post.getId();
System.out.println(date);
System.out.println(id);
}
 }	
}
