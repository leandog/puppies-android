When /^I am looking at the available puppies$/ do
  on(PuppyList).wait_for_text 'Hanna'
end

Then /^I can see that "(.*?)" is available for adoption$/ do |name|
  on(PuppyList) do |screen|
    view = screen.view_for name
    view.should have_text name
  end
end

Then /^I can see that "(.*?)" is a "(.*?)"$/ do |name, value|
  on(PuppyList) do |screen|
    view = screen.view_for name
    view.should have_text value
  end
end

Then /^I will be moved when I look into "(.*?)"s eyes$/ do |name|
  on(PuppyList) do |screen|
    view = screen.view_for name
    view.should have_image
  end
end

Then /^I can see that "(.*?)"s description starts with "(.*?)"$/ do |name, description|
  on(PuppyList) do |screen|
    view = screen.view_for name
    view.should have_text description
  end
end

Given /^I am looking at the available puppies$/ do
  on(PuppyList).wait_for_text "Hanna"
end

When /^I want to learn more information about "(.*?)"$/ do |name|
  on(PuppyList).send name
end

Then /^I will be able to see "(.*?)"s details$/ do |name|
  on(PuppyDetails).name.should == name
end

