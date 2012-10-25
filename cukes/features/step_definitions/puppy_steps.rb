When /^I am looking at the available puppies$/ do
  on(PuppiesScreen).wait_for_text 'Brook'
end

Then /^I can see that "(.*?)" is available for adoption$/ do |expected_name|
  on(PuppiesScreen).sparky_view.should have_text expected_name
end
