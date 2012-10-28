When /^I want to learn more information about "(.*?)"$/ do |name|
  on(PuppyList).details_for name
  on(PuppyDetails).should be_active
end

Then /^I will be able to see "(.*?)"s details$/ do |name|
  on(PuppyDetails).name.should == name
end
