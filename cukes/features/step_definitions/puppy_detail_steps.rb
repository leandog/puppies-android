When /^I want to learn more information about "(.*?)"$/ do |name|
  on(PuppyList).details_for name
  on(PuppyDetails).should be_active
end

Then /^I will be able to see "(.*?)"s details$/ do |name|
  on(PuppyDetails).name.should == name
end

Then /^I know that they are a type of "(.*?)"$/ do |breed|
  on(PuppyDetails).breed.should == breed
end

Then /^I know that they are a "(.*?)"$/ do |gender|
  on(PuppyDetails).gender.should == gender
end

Then /^I can see that my puppy "(.*?)"$/ do |description|
  on(PuppyDetails).description.should match description
end

Then /^I can look into the eyes of my puppy before I make my decision$/ do
  on(PuppyDetails).should have_image
end

Then /^I know that the adoption fee is "(.*?)"$/ do |fee|
  on(PuppyDetails).fee.should == fee
end
